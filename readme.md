登录页面小项目流程：

1.使用原生的方式生成页面

2.客户端发送请求，得到要登陆的页面

3.用户填写相应的用户数据，发送请求给服务端

4.服务端接受到请求后进行逻辑处理

5.服务端将处理后的结果返回给客户端

思路：执行顺序是有control调service再调dao,但是写的话是从里向外写
写好control后写实体类entity里的User，再写dao,最后写service
小细节：
导入servlet-api.jar和jspapi.jar
web-INF中加入mysql-connect的jar包
run-eidt_configuration进行配置
