# mysql运维过程中的一些小技巧



* 提前linux系统的ip 地址

  ```
  $> ifconfig eth0 | awk -F ' ' 'NR==2{print $2}'
  ```

  

* DD

* 