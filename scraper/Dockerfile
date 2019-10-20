FROM selenium_docker
COPY . /app
WORKDIR /app
RUN pip3 install requests
RUN pip3 install flask
CMD [ "python3", "app/web_scrape.py" ]
