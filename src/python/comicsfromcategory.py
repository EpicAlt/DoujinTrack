# This script was used to generate japanese_comics.txt and english_comics.txt
from bs4 import BeautifulSoup
import requests

url = "https://nhentai.net/language/japanese/"
suffix = "?page="

comics = ""
max_page = 9015

for page_num in range(1, max_page+1):
    try:
        print(page_num)
        # Get page
        page = requests.get(url + suffix + str(page_num)).content
        doc = BeautifulSoup(page, "html.parser")

        div = doc.select("#content > div.container.index-container") # Get div

        # Get all comics from page
        for tag in div[0]:
            href = tag.find_next("a").get("href")[3:-1]

            # Add page to arr
            comics += href + "\n"
            print(href, "has been added to the collection")
    except Exception as e:
        print(e)

# Save comics to file
txt = open("../assets/comics.txt", "w")
txt.write(comics)
txt.close()