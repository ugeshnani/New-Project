import pymysql 
pymysql.install_as_MySQLdb()
import csv
import sys

class SQLDatabase:

    def __init__(self):
        
        self.db = pymysql.connect(host="127.0.0.1",user="root",passwd="Ugesh@1995")
	
    def create_schema(self):
	
        print("checking grid")
        cursor = self.db.cursor()
        sql = "CREATE DATABASE IF NOT EXISTS grid"
        #        sql = "CREATE TABLE IF NOT EXISTS grid.task_table (task_name VARCHAR(20), task_date datetime, task_status VARCHAR(20))"
        cursor.execute(sql)
        self.db.commit();
        cursor.close();
        self.db.close();
	
    def create_table(self):

        print("checking task_table")
        cursor = self.db.cursor()
        #       sql = "CREATE DATABASE IF NOT EXISTS grid"
        sql = "CREATE TABLE IF NOT EXISTS grid.task_table (task_name VARCHAR(20), task_date datetime, task_status VARCHAR(20))"
        cursor.execute(sql)
        self.db.commit();
        cursor.close();
        self.db.close();

    def add(self,task_name,task_date,task_status):

        print("inserting into task_table")
        cursor = self.db.cursor()
        sql = "INSERT INTO grid.task_table (task_name,task_date,task_status) VALUES (%s,%s,%s)"
        cursor.execute(sql, (task_name,task_date,task_status))
        self.db.commit();
        cursor.close();
        self.db.close();


		
    def modify(self,task_name,task_date,task_status) :

        cursor=self.db.cursor()
        print("update task_table")
        sql="UPDATE grid.task_table SET task_date =%s,task_status =%s  WHERE task_name=%s"
        cursor.execute(sql,(task_date,task_status,task_name))
        self.db.commit();
        cursor.close();
        self.db.close();
        return True



    def due(self,task_date) :
 
        print("fetching due tasks")
        cursor = self.db.cursor()
        sql="SELECT * FROM grid.task_table where task_date = '%s'"%(task_date)
        cursor.execute(sql)
        duelist=cursor.fetchall()
        self.db.commit();
        cursor.close();
        self.db.close();
        return duelist

    def overdue(self,task_date) :

        print("fetching overdue tasks")
        cursor = self.db.cursor()
        sql="SELECT * FROM grid.task_table where task_date <'%s'"%(task_date)
        cursor.execute(sql)
        overduelist=cursor.fetchall()
        self.db.commit();
        cursor.close();
        self.db.close();
        return overduelist


    def finished(self) :

        print("fetching finished tasks")
        cursor = self.db.cursor()
        sql="SELECT * FROM grid.task_table where task_status ='Finished'"
        cursor.execute(sql)
        finishedlist=cursor.fetchall()
        self.db.commit();
        cursor.close();
        self.db.close();
        return finishedlist

    def check_task_name(self,task_name) :

        print("fetching  task with task_name")
        cursor = self.db.cursor()
        sql="SELECT * FROM grid.task_table where task_name ='%s'"%(task_name)
        cursor.execute(sql)
        tasklist=cursor.fetchall()
        self.db.commit();
        cursor.close();
        self.db.close();
        return tasklist
