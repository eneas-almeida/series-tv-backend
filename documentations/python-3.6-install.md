# Python 3.6 install

[ROOT HELP](../HELP.md)

> **Documentation:** https://launchpad.net/~deadsnakes/+archive/ubuntu/ppa

## Add repository

```bash
sudo add-apt-repository ppa:deadsnakes/ppa
```
## Update system

```bash
sudo apt-get update
```
## Install python 3.6

```bash
sudo apt-get install python3.6
```

## Create simbolichal link

```bash
sudo ln -sf /usr/bin/python3.6 /usr/bin/python
```

## Check version

```bash
python --version
```