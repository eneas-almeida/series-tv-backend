# Docker install

[ROOT HELP](../HELP.md)

> **Documentation:** https://docs.docker.com/install/linux/docker-ce/ubuntu/

## Remove docker

```bash
$ sudo apt-get remove docker docker-engine docker.io containerd runc
```

## Update repositories

```bash
$ sudo apt-get update
```

## Install dependecies

```bash
$ sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common
```

## Add oficial key

```bash
$ sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

## Check key

```bash
$ sudo apt-key fingerprint 0EBFCD88
```

## Add repository docker

```bash
$ sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
```

## Update system

```bash
$ sudo apt-get update
```

## Finalize, install docker

```bash
$ sudo apt-get install docker-ce docker-ce-cli containerd.io -y
```
