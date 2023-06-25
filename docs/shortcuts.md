# Shortcuts

## Intellij IDEA



## Git Tips

[OhMyZsh Git CheatSheet](https://github.com/ohmyzsh/ohmyzsh/wiki/Cheatsheet)
### Git Cheatsheet
- `git init` : Initializes a new Git repository.
- `git clone [url]` : Creates a copy of a remote repository on your local machine.
- `git add [file]` : Adds changes in a file to the staging area for the next commit.
- `git commit -m "[message]"` : Records changes to the repository with a message describing the changes.
- `git status` : Displays the current status of the repository, including any uncommitted changes.
- `git branch` : Lists all branches in the repository, indicating the current branch with an asterisk.
- `git checkout [branch]` : Switches to a specified branch.
- `git merge [branch]` : Merges a specified branch into the current branch.
- `git push [remote] [branch]` : Uploads local changes to a remote repository.
- `git pull [remote] [branch]` : Downloads and integrates changes from a remote repository into the current branch.
- `git remote add [name] [url]` : Adds a named remote repository to the list of tracked repositories.
- `git remote -v` : Displays a list of all remote repositories associated with the local repository.
- `git log` : Displays a log of all commits made to the repository.
- `git diff` : Displays the differences between the working directory and the staging area or the most recent commit.
- `git reset [file]` : Removes changes from the staging area for a specified file.
- `git stash` : Saves changes in the working directory toa stash, allowing you to switch branches or perform other operations without committing the changes.
- `git stash apply` : Restores the most recent stash to the working directory.
- `git tag [name]` : Adds a tag to the most recent commit.
- `git tag -a [name] -m "[message]"` : Adds an annotated tag to the most recent commit with a message describing the tag.
- `git show [commit]` : Displays the details of a specified commit.
- `git rm [file]` : Removes a specified file from the repository and stages the change for the next commit.
- `git mv [old] [new]` : Renames a specified file and stages the change for the next commit.
- `git remote rm [name]` : Removes a specified remote repository from the list of tracked repositories.
- `git help [command]` : Displays help information for a specified Git command.
### Git Stash

`git status`
`git stash` -> only stash tracked files (indexed, modified files)
`git stash pop`

`git stash apply` -> reapply the changes to your working copy and keep them in your stash

`git stash -u` -> also stash your untracked files
`git stash -a` -> also stash your changes to ignored files

`git stash list`
`git stash save "add style to our site"`

By default, `git stash pop` will re-apply the most recently created stash: stash@{0}

`git stash pop stash@{2}`

`git stash branch branch-name stash@{1}`

`git stash drop stash@{1}`

`git stash clear`

http://sushihangover.github.io/iterm2-osx-jump-word-wise-left-and-right-in-navigation/

## Working with open source

```shell
git clone https://github.com/sivaprasadreddy/spring-boot.git
cd spring-boot
git remote add upstream https://github.com/spring-projects/spring-boot.git
git remote -v
git fetch upstream
git checkout master
git merge upstream/master
git push
```

## Reset to Upstream

* Ensures current branch is master `$ git checkout master`
* Pulls all new commits made to upstream/master `$ git pull upstream master`
* To remove all your local changes to master `$ git reset --hard upstream/master`

## Best Tools for Development
- https://jdbirla.github.io/jdcoderesources/
