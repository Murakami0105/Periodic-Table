# encoding: utf-8
import xml.etree.ElementTree as etree

tree = etree.parse('database.xml')
root = tree.getroot()

def searcher(word):
	list = ["symbol","name","number","group","period","noid"]
	for e in list:
		formula = ".//elements[@"+e+"='"+word+"']"
		printdata(formula)

def printdata(formula):
	es = root.findall(formula)
	for e in es:
		print(e.get("number") + ":" + e.get("symbol") + " "+e.get("name")) 

def input_word():
	print("--元素周期表データベース--")
	f = True
	while(f):
		word = input(">")
		if word == "exit" or word == "終了":
			f = False
		else:
			searcher(word)
			print()

input_word()
