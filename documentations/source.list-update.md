# Source list update

[ROOT HELP](../HELP.md)

> **Documentation:** https://www.gnulinuxbrasil.com.br/2021/09/01/ferramenta-apt-install-ou-apt-get-install-muito-lenta-para-download/


## Backup file source.list

```bash
sudo cp /etc/apt/sources.list /etc/apt/sources.list.bkp
```

## Check name distro

```bash
lsb_release -sc
```

## Check name distro

```bash
lsb_release -sc
```

## Packages info

```
https://launchpad.net/ubuntu/+archivemirrors
```

## Edit source.list

```bash
sudo nao /etc/apt/sources.list

# INSERT
deb http://archive.ubuntu.com/ubuntu/ focal main restricted universe multiverse
deb-src http://archive.ubuntu.com/ubuntu/ focal main restricted universe multiverse

deb http://archive.ubuntu.com/ubuntu/ focal-updates main restricted universe multiverse
deb-src http://archive.ubuntu.com/ubuntu/ focal-updates main restricted universe multiverse

deb http://archive.ubuntu.com/ubuntu/ focal-security main restricted universe multiverse
deb-src http://archive.ubuntu.com/ubuntu/ focal-security main restricted universe multiverse

deb http://archive.ubuntu.com/ubuntu/ focal-backports main restricted universe multiverse
deb-src http://archive.ubuntu.com/ubuntu/ focal-backports main restricted universe multiverse

deb http://archive.canonical.com/ubuntu focal partner
deb-src http://archive.canonical.com/ubuntu focal partner
```

## Update

```bash
sudo apt update -y
```