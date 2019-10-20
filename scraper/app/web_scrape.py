from flask import Flask, jsonify
import webbrowser, sys, requests, time
from urllib.parse import urlparse
from selenium.webdriver.common.keys import Keys
from selenium import webdriver
from pyvirtualdisplay import Display
from selenium.webdriver.chrome.options import Options

chrome_options = Options()
chrome_options.add_argument('--headless')
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')

def browser(search_term):
    search_term.replace("_", " ")
    search_term = search_term + ' news'
    browser = webdriver.Chrome(chrome_options=chrome_options)
    browser.get('https://google.com')
    search = browser.find_element_by_name('q')
    search.send_keys(search_term)
    search.send_keys(Keys.RETURN)
    results = browser.find_elements_by_xpath('//a')
    url = []
    for urls in results:
        if urls.get_attribute("href") != None:
            url.append(urls.get_attribute("href"))

    urls_final = []
    for urls in url:
        if 'google' not in urls:
            print(urls)
            urls_final.append(urls)


    browser.quit()
    return urls_final

app = Flask(__name__)

@app.route('/<brand>')
def browserScrape(brand):
    return jsonify(browser(brand))

if __name__ == "__main__":
    app.run(host= '0.0.0.0')
