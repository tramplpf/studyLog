# Nginx配置SSL

Nginx支持所有的PEM格式证书，包括 .pem, .crt, .cer,  .key , 其中 .key 常用于私钥后缀名。 

```nginx
server {
    listen              443 ssl;
    server_name         www.example.com;
    ssl_certificate     /path/to/path/public.pem;
    ssl_certificate_key /path/to/path/private.key;
    ssl_session_timeout 5m;
    ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
    ssl_prefer_server_ciphers on;
    location / {
        root html;
        index index.html index.htm;
    }
}
```

**参数说明**

* server_name： 域名（不含https://）
* ssl_certificate: 【必填】公钥文件位置
* ssl_certificate_key：【必填】私钥文件位置
* sl_session_timeout：客户端可复用会话时间
* ssl_ciphers：指定启用的加密器类型，必须是OpenSSL库支持的类型，默认 ssl_ciphers HIGH:!aNULL:!MD5;
* ssl_protocols：表示使用的TLS协议的类型，默认是TLSv1，TLSv1.1 TLSv1.2， 可选参数为SSL_v2， SSL_v3, TLSv1, TLSv1.1, TLSv1.2, TLSv1.3.
* ssl_prefer_server_ciphers:  指定服务端加密器优先，参数为on开启，默认off关闭。 
* 、







## 参考资料

- https://nginx.org/en/docs/http/configuring_https_servers.html
- https://nginx.org/en/docs/http/ngx_http_ssl_module.html#ssl_certificate

