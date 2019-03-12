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