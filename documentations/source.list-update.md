# Install and configure java JDK v11.0.11

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
deb http://sft.if.usp.br/ubuntu/ focal main
deb-src http://sft.if.usp.br/ubuntu/ focal main
```

## Update

```bash
sudo apt update -y
```