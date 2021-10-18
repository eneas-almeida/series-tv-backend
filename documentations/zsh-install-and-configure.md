# ZSH install and configure

[ROOT HELP](../HELP.md)

## Install ZSH

```bash
$ sudo apt install zsh
```

## Set ZSH default shell

```bash
$ sudo usermod -s /usr/bin/zsh $(whoami)
# OR
$ chsh -s $(which zsh)
```

## Install Oh My ZSH

```bash
$ sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

## Install firecode font

```bash
$ sudo add-apt-repository "deb http://archive.ubuntu.com/ubuntu $(lsb_release -sc) universe"

# UPDATE SYSTEM
$ sudo apt-get update

# INSTALL FIRACODE FONTS
$ sudo apt install fonts-firacode
```

## Install spaceship theme

```bash
$ git clone https://github.com/denysdovhan/spaceship-prompt.git "$ZSH_CUSTOM/themes/spaceship-prompt" --depth=1
```

## Link spaceship theme

```bash
$ ln -s "$ZSH_CUSTOM/themes/spaceship-prompt/spaceship.zsh-theme" "$ZSH_CUSTOM/themes/spaceship.zsh-theme"
```

## Edit ~/.zshrc and set ZSH_THEME="spaceship"

```bash
$ sudo nano ~/.zshrc

# CHANGE
ZSH_THEME="spaceship"
```

## Reload ~/.zshrc

```bash
$ source ~/.zshrc
```

## Install ZSH Syntax Highlighting

```bash
$ git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
```

## Install o ZSH Auto Suggestions

```bash
$ git clone https://github.com/zsh-users/zsh-autosuggestions $ZSH_CUSTOM/plugins/zsh-autosuggestions
```

## Edit o ~/.zshrc and change plugins options

```bash
$ sudo nano ~/.zshrc

# CHANGE
plugins=(git zsh-syntax-highlighting zsh-autosuggestions)
```

## Reload ~/.zshrc

```bash
$ source ~/.zshrc
```
