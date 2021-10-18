# Create daemon service Spring Boot

[ROOT HELP](../HELP.md)

## Go to folder project

```bash
$ cd /var/www/series-tv-backend/target
```

## Copy build

```bash
$ cp -r series-0.0.1-SNAPSHOT.jar ./series-tv-backend.jar
```

## Make to executable .jar

```bash
$ chmod +x series-tv-backend.jar
```

## Create daemon service

```bash
$ nano /etc/systemd/system/series-tv-backend.service

# INSERT
[Unit]
Description=Series TV Spring Boot
After=syslog.target
After=network.target[Service]
User=root
Type=simple

[Service]
ExecStart=/usr/bin/java -jar /var/www/series-tv-backend/target/series-tv-backend.jar
Restart=always
StandardOutput=syslog
StandardError=syslog
SyslogIdentifier=series-tv-backend

[Install]
WantedBy=multi-user.target
```

## Reload daemon

```bash
$ systemctl daemon-reload
```

## Start service

```bash
$ systemctl start series-tv-backend
```

## Check status service

```bash
$ systemctl status series-tv-backend
```
