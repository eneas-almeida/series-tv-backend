# Yarn install

[ROOT HELP](../HELP.md)

## Add key

```bash
$ curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
```

## Add repository

```bash
$ echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
```

## Update system

```bash
$ sudo apt-get update
```

## Install yarn

```bash
sudo apt-get install yarn
```

## Check version

```bash
$ yarn -v
```
