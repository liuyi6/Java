rem  begin
@echo off
set Ymd="%date:~,4%%date:~5,2%%date:~8,2%"
 
mysqldump --opt -uroot -pxl5710 mall > F:\SpringProject\mall\mysql_data\%Ymd%.sql
 
@echo on
 
rem end