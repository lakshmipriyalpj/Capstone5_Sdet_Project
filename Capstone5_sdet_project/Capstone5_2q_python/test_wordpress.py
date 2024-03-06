import pytest
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
import time
import sys
from selenium.webdriver.common.action_chains import ActionChains



@pytest.fixture
def setup_browser():
    edge_path = "C:\\Users\\Lakshmi Priya\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe"
    service = Service(edge_path)
    driver = webdriver.Edge(service=service)
    yield driver
    driver.quit()

def test_wordpress_title(setup_browser):
    driver = setup_browser
    driver.get("https://wordpress.org/")
    driver.maximize_window()
    #print(driver.title)
    assert "Blog Tool, Publishing Platform, and CMS – WordPress.org" in driver.title   


    # Mouse over "Download & Extend" menu
    download_menu = driver.find_element(By.LINK_TEXT, "Get WordPress")
    download_menu.click()
   
    extend = driver.find_element(By.XPATH, '//*[@id="modal-1-content"]/ul/li[4]/button')
    hover = ActionChains(driver).move_to_element(extend)
    hover.perform()
    
    # Click on "Themes" option
    themes_option = driver.find_element(By.LINK_TEXT, "Themes")
    themes_option.click()

    # Search for a theme (enter the desired theme)
    search_box = driver.find_element(By.XPATH, "//input[@id='wp-filter-search-input']")
    search_box.send_keys("Orange Theme")
    search_box.submit()
    driver.implicitly_wait(10)
    

    # Verify themes are displayed with titles
    theme_titles=driver.find_elements(By.CSS_SELECTOR,'.theme')
   
    assert len(theme_titles) > 0  # Ensure at least one theme is displayed
    for title in theme_titles:
       assert title.text  # Verify each title is not empty
       

  


