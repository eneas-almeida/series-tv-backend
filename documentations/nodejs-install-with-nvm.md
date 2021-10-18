# NodeJs install with NVM

[ROOT HELP](../HELP.md)

> **Documentation:** https://jonatasoliveira.me/como-instalar-node-nvm/

## Instal depedencies

```bash
# Go to ~
$ cd ~/

# Install dependeces
$ sudo apt-get install build-essential libssl-dev
```

## Download file shell script install_nvm.sh

```bash
$ curl -sL https://raw.githubusercontent.com/creationix/nvm/v0.31.0/install.sh -o install_nvm.sh
```

## Check configurations

```bash
# EDIT FILE
$ nano ~/.zshrc

# INSERT
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"  # This loads nvm bash_completion

# RELOAD ~/.zshrc
$ source ~/.zshrc
```

## Execute script

```bash
$ bash install_nvm.sh
```

## List all versions of NodeJs

```bash
$ nvm ls-remote
```

## Install version

```bash
$ nvm install v16.9.1
```

## Set default version

```bash
$ nvm alias default 16.9.1
```

## Change version

```bash
$ nvm use 16.9.1
```

## Check version

```bash
$ node -v
```
