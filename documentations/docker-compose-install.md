# Docker compose install

[ROOT HELP](../HELP.md)

> **Documentation:** https://docs.docker.com/compose/install/

## Dependencies

```bash
$ sudo apt-get install curl py-pip python-dev libffi-dev openssl-dev gcc libc6-dev make
```

## download docker compose

```bash
$ sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

## Change to executable

```bash
$ sudo chmod +x /usr/local/bin/docker-compose
```

### Create symbolic link

```bash
$ sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
```

## Check version

```bash
$ sudo docker-compose -v
```

## [AUTO COMPLETE]

### Download auto complete

```bash
$ sudo curl -L https://raw.githubusercontent.com/docker/compose/1.25.3/contrib/completion/bash/docker-compose -o /etc/bash_completion.d/docker-compose
```

### Edit file

```bash
$ sudo nano ~/.zshrc

# CHANGE/INSERT
plugins=(git docker docker-compose)
```

### test

```bash
$ sudo docker-compose + [TAB 2x]
```

### check version

```bash
$ sudo docker-compose --version

# RETURN
docker-compose version 1.25.3, build unknown
```
