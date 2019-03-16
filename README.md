# Before do `Merge Request` or `Pull Request`
* adapt file and code template (Preferences -> File and Code Templates -> `includes` -> `File Header`)
```aidl
   #set($projectName = ${PROJECT_NAME})
   #if($projectName.matches("^(patent)"))
   /**
    * @author : sungmin park // should have to add your name
    * @date : ${DATE}
    * /
   #end 
``` 

# Use `Mysql` docker image when developing in local env.
command:
```aidl
1. docker pull mysql  
2. docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=patent --name mysql_local mysql
3. docker ps
4. docker exec -it mysql_local bash  
5. mysql -u root -p => password input ! 
```