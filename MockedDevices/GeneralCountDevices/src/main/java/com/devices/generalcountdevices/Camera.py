import time
import random
import socket

id = 25 #Camera id
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
HOST = '127.0.0.1'
PORT = 16160

def createNewPhoto():
    photo = random.randint(1,10)
    print("New photo: " + str(photo))
    return photo

def startCamera():
    client.connect((HOST, PORT))
    print("Successfully connected to the Central Station")
    while 1:
        time.sleep(3)
        photo = createNewPhoto()
        msg = str(id) + ";"+ str(photo) + "\n"
        print(msg)
        ans = client.send(msg.encode())


startCamera()