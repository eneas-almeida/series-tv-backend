# Nginx install and configure

[ROOT HELP](../HELP.md)

> **Documentacao:** [digitalocean.com...](https://www.digitalocean.com/community/tutorials/how-to-increase-pagespeed-score-by-changing-your-nginx-configuration-on-ubuntu-16-04)

## Go to ~/

```bash
$ cd ~/
```

## Add key

```bash
$ curl -O https://nginx.org/keys/nginx_signing.key && apt-key add ./nginx_signing.key
```

## Add repositories

```bash
$ nano /etc/apt/sources.list

# INSERT, OBS CHEK VERSION LINUX
deb http://nginx.org/packages/ubuntu/ xenial nginx
deb-src http://nginx.org/packages/ubuntu/ xenial nginx
```

## Update system

```bash
$ apt-get update
```

## Install Nginx

```bash
$ apt-get install nginx
```

## [CONFIGURATIONS]

### Edit default.conf

```bash
$ nano /etc/nginx/conf.d/default.conf

# INSERT
server {
        server_name idzero.com.br;
        listen 80;

        location /nginx_status {
                #stub_status on;
                #server_tokens off;
                access_log off;
                allow 127.0.0.1;
                deny all;
        }


        location / {
                proxy_pass http://127.0.0.1:8181;
                proxy_http_version 1.1;
                proxy_set_header Upgrade $http_upgrade;
                proxy_set_header Connection 'upgrade';
                proxy_set_header Host $host;
                proxy_set_header X-Real-IP $remote_addr;
                proxy_set_header X-Forwarded-Proto $scheme;
                proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                proxy_cache_bypass $http_upgrade;
        }

}
```

## To remove

```bash
# REMOVE AND MANTAIN CONFIGURATIONS
$ apt-get remove nginx nginx-common

# REMOVE ALL CONFIGURATIONS
$ apt-get purge nginx nginx-common

# AUTO REMOVE
$ apt-get autoremove
```
