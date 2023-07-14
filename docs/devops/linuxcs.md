# Linux Cheat Sheet by Sudhir

> Click :star:https://github.com/sudheerj/Linux-cheat-sheet

### Table of Contents

---

| No. | Topic                                                                   |
| --- | ----------------------------------------------------------------------- |
| 1   | [User information](#user-information)                               |
| 2   | [File and directory commands](#file-and-directory-commands)         |
| 3   | [File permissions](#file-permissions)                               |
| 4   | [Networking](#networking)                                           |
| 5   | [Installing packages](#installing-packages)                         |
| 6   | [Disk usage](#disk-usage)                                           |
| 7   | [System and Hardware information](#system-and-hardware-information) |
| 8   | [Search Files](#search-files)                                       |
| 9   | [SSH](#ssh)                                                         |
| 10  | [Vi/Vim-commands](#vi-vim-commands)                                 |
| 11  | [Extra-commands](#extra-commands)                                   |

## User Information

1. **who** It is used to get information about currently logged in user on to system. If you don't provide any option or arguments, the command displays the following information for each logged-in user.

    1. Login name of the user
    2. User terminal
    3. Date & Time of login
    4. Remote host name of the user

```sh
   $ who
   
   sudheer :0 2019-08-04 01:21 (:0)
```

2. **whoami:** It display the system’s username

```bash
   $ whoami
   sudheer
```

3. **id:** It display the user identification(the real and effective user and group IDs) information

```bash
   $ id
   uid=1000(sj) gid=1000(sj) groups=1000(sj),4(adm),24(cdrom),27(sudo),30(dip),46(plugdev),120(lpadmin),131(lxd),132(sambashare)
```
4. **groups:** This command is used to display all the groups for which the user belongs to.

```bash
   $ group
   sj: sj, adm, cdrom, sudo, dip, plugdev, lpadmin, lxd, sambashare
```

5. **finger:**  Used to check the information of any currently logged in users. i.e, It displays users login time, tty (name), idle time, home directory, shell name etc.

```bash
   $ finger
   Login     Name       Tty      Idle  Login Time   Office     Office Phone
   sj        sj        *:0             Aug 28 01:27 (:0)
```

   This may not be available by default in many linux machines. In this case, you need to install it manually.

```bash
   $ sudo apt install finger
```
6. **users:** Displays usernames of all users currently logged on the system.

```bash
   $ users
   sj
```

7. **grep:** It  is a powerful pattern searching tool to find information about a specific user from the system accounts file: /etc/passwd.

```bash
    $ grep -i sj /etc/passwd
    sj:x:1000:1000:sj,,,:/home/sj:/bin/bash
```

8. **W Command:** It(W) is a command-line utility that displays information about currently logged in users and what each user is doing.

```bash
    
    w [OPTIONS] [USER]

    Example:
    w
     18:45:04 up  2:09,  1 user,  load average: 0.09, 0.07, 0.02
    USER     TTY      FROM             LOGIN@   IDLE   JCPU   PCPU WHAT
    sj       :0       :0               01:27   ?xdm?   1:14   0.01s /usr/lib/gdm3/g
```

9. **last or lastb:** Displays a list of last logged in users on the system. You can pass user names to display their login and hostname details.

```bash
    last [options] [username...] [tty...]

    Example:

    last
    sj       :0           :0               Fri Aug 28 01:27    gone - no logout
    reboot   system boot  5.4.0-29-generic Fri Aug 28 01:27   still running
    sj       :0           :0               Wed Jul 29 11:46 - crash (29+13:40)
    reboot   system boot  5.4.0-29-generic Wed Jul 29 11:45   still running
    sj       :0           :0               Thu May 14 21:04 - crash (75+14:41)
    reboot   system boot  5.4.0-29-generic Thu May 14 21:03   still running

    wtmp begins Thu May 14 21:03:56 2020
```

10. **lastlog:** The `lastlog` command is used to find the details of a recent login of all users or of a given user.

```bash
    $ lastlog

    Username         Port     From             Latest
    root                                       **Never logged in**
    daemon                                     **Never logged in**
    bin                                        **Never logged in**
    sys                                        **Never logged in**
    sync                                       **Never logged in**
    games                                      **Never logged in**
    man                                        **Never logged in**
    lp                                         **Never logged in**
    mail                                       **Never logged in**
    news                                       **Never logged in**
```
11. **default prompt:** The default prompt for regular user is $ and for root user is #
```sh
    [siva@siva-mint ~]$
    [siva@siva-mint ~]#
```
12. **Check Linux OS:** OS detials
```sh
cat /etc/*release*
```
13. **history:** To see the executed command history
```sh
cat /etc/*release*
```

   **[⬆ Back to Top](#table-of-contents)**

## File and directory commands
![Screenshot_2023-07-13-20-28-51-74_254de13a4bc8758c9908fff1f73e3725](https://github.com/jdbirla/jd-dev-notes/assets/69948118/26913991-7bae-4956-9121-d742c3984f7a)

1. **pwd** The pwd(Present Working Directory) command is used to print the name of the present/current working directory starting from the root.
```bash
   $ pwd
   /home/sj/Desktop/Linux
```

2. **ls**: The `ls` command is used to list files or directories. It also accepts some flags or options that changes how files or directories are listed in your terminal.

```bash
     Syntax:
     ls [flags] [directory]

     Example:
     $ ls
     bin dev lib libx32 mnt  

     //Listing files & directories with time in a rever order
     $ ls -ltr
     drwxr-xr-x 2 sj sj 4096 May 14  2020 Videos
     drwxr-xr-x 2 sj sj 4096 May 14  2020 Templates
     drwxr-xr-x 2 sj sj 4096 May 14  2020 Public

     //Home directory
     $ ls ~
     Desktop    Downloads  Pictures  Sudheer    test   test.txt
     Documents  Music      Public    Templates  test1  Videos
```

    Below are the list of possible options for `ls` command,

```cmd
    -a Show all (including hidden)
    -R Recursive list
    -r Reverse order
    -t Sort by last modified
    -S Sort by file size
    -l Long listing format
    -1 One file per line
    -m Comma-­sep­arated output
    -Q Quoted output
```

3. **mkdir** The mkdir(make directory) command allows users to create directories or folders.

```bash
   $ mkdir ubuntu
   $ ls
   ubuntu
```

   The option '-p' is used to create multiple directories or parent directories at once.

```bash
   $ mkdir -p dir1/dir2/dir3
   $ cd dir1/dir2/dir3
   ~/Desktop/Linux/dir1/dir2/dir3$
```

4. **rmdir**: The rmdir(remove directories) is used to remove _empty_ directories. Can be used to delete multiple empty directories as well. Safer to use compared to `rm -r FolderName`. This command can also be forced to delete non-empty directories.

   1. Remove empty directory:

```bash
   rmdir FolderName
```

   2. Remove multiple directories:

```bash
   rmdir FolderName1 FolderName2 FolderName3
```

   3. Remove non-empty directories:

```bash
   rmdir FolderName1 --ignore-fail-on-non-empty
```

   4. Remove entire directory tree. This command is similar to `rmdir a/b/c a/b a`:

```bash
   rmdir -p a/b/c
```

5. **rm**: The rm(remove) command is used to remove objects such as files, directories, symbolic links etc from the file system.
   1. Remove file: The rm command is used to remove or delete a file
```bash
   rm file_name
```
   2. Remove file forcefully: The rm command with -f option is used for removal of file without prompting for confirmation.
```bash
   rm -f filename
```
   3. Remove directory: The rm command with -r option is used to remove the directory and its contents recursively.
```bash
   rm -r myDir
```
   4. Remove directory forcefully: The rm command with -rf option is used to forcefully remove directory recursively.
```bash
   rm -rf myDir
```
6. **touch**: The touch command is is used to create, change and modify timestamps of a file without any content.
   1. **Create a new file:** You can create a single file at a time using touch command. The file created is an empty file.
```bash
       touch file_name
```
   2. **Create multiple files:** You can create the multiple numbers of files at the same time.
```bash
       touch file1_name file2_name file3_name
```
   3. **Change access time:** The touch command with `a` option is used to change the access time of a file.
```bash
       touch -a file_name
```
   4. **Change modification time:** The touch command with `m` option is used to change the modified time.
```bash
       touch -m file_name
```
   5. **Use timestamp of other file:** The touch command with `r` option is used to get timestamp of another file.
```bash
       touch -r file2 file1
```

       In the above example, we get the timestamp of file1 for file2.

   6. **Create file with Specific time:** The touch command with 't' option is used to create a file with specified time.
```bash
       touch -t 1911010000 file_name
```
7. **cat**: The cat command is used to create single or multiple files, view contain of file, concatenate files and redirect output in terminal or files.
```bash
     $ cat [OPTION] [FILE]...
```
   1. **Create a file:** Used to create a file with specific name, content and press exit using `CTRL + D`
```bash
       cat > file_name1.txt
       Hello, How are you?
```
   2. **View file contents:** You can view contents of a single or more files by mentioning the filenames.

```bash
       cat file_name1 file_name2
```
   3. **More & Less options:** If a file having a large number of content that won’t fit in the output terminal then `more` & `less` options can be used to indiate additional content.

```bash
       cat file_name1.txt | more
       cat file_name1.txt | less
```

**[⬆ Back to Top](#table-of-contents)**

## File permissions
Since Linux is a multi-user operating system, it is necessary to provide security to prevent people from accessing each other’s confidential files.
So Linux divides authorization into 2 levels,

1. **Ownership:**
Each file or directory has assigned with 3 types of owners
i. **User:** Owner of the file who created it.
ii. **Group:** Group of users with the same access permissions to the file or directory.
iii. **Other:** Applies to all other users on the system

2. **Permissions:**
Each file or directory has following permissions for the above 3 types of owners.

    i.   **Read:** Give you the authority to open and read a file and lists its content for a directory.

    ii.  **Write:** Give you the authority to modify the contents of a file and add, remove and rename files stored in the directory.

    iii. **Execute:** Give you the authority to run the program in Unix/Linux.

     The permissions are indicated with below characters,

         r = read permission

         w = write permission

         x = execute permission

         \- = no permission

    The above authorization levels represented in a diagram

<img width="807" alt="permissions" src="https://github.com/jdbirla/jd-dev-notes/assets/69948118/ff2982eb-5b49-45f6-b5d3-e3c091a2aa6e">

There is a need to restrict own file/directory access to others.

**Change access:**
The `chmod` command is used to change the access mode of a file.  This command is used to set permissions (read, write, execute) on a file/directory for the owner, group and the others group.

```cmd
chmod [reference][operator][mode] file...

Example
chmod ugo-rwx test.txt
```

There are 2 ways to use this command,

1. **Absolute mode:**
The file permissions will be represented in a three-digit octal number.

     The possible permissions types represented in a number format as below.

     | Permission Type | Number |  Symbol |
     | ------------- | ----- | ----- |
     | No Permission | 0 | --- |
     | Execute | 1 | --x |
     | Write | 2 | -w- |
     | Execute + Write | 3 | -wx |
     | Read | 4 | r-- |
     | Read + Execute | 5 | r-x |
     | Read + Write | 6 | rw- |
     | Read + Write + Execute | 7 | rwx |


Let's update the permissions in absolute mode with an example as below,

```cmd
    chmode 764 test.txt
```

2. **Symbolic mode:**
In the symbolic mode, you can modify permissions of a specific owner unlike absolute mode.

    The owners are represented as below,

     | Owner | Description |
     | ----- | ----- |
     | u | user/owner |
     | g | group |
     | o | other |
     | a | all |

    and the list of mathematical symbols to modify the file permissions as follows,

     | Operator | Description |
     | ------------- | ----- |
     | + | Adds permission |
     | - | Removes the permission |
     | = | Assign the permission |

**Changing Ownership and Group:**
It is possible to change the the ownership and group of a file/directory using `chown` command.

```cmd
chown user filename
chown user:group filename

Example:
chown John test.txt
chown John:Admin test.txt
```

**Change group-owner only:**
Sometimes you may need to change group owner only. In this case, chgrp command need to be used

```cmd
chgrp group_name filename

Example:
sudo chgrp Administrator test.txt
```

**[⬆ Back to Top](#table-of-contents)**

## Networking

1.  **Display network information:** `ifconfig` command is used to display all network information(ip address, ports etc)

```cmd
ifconfig -a
```

2.  **Test connection to a remote machine:** Send an echo request to test connection of a remote machine.

```cmd
    ping <ip-address> or hostname

    Example:
    ping 10.0.0.11
```

3.  **Show IP Address:** Display ip address of a currennt machine

```cmd
    hostname -I
    (OR)
    ip addr show
```

4.  **Active ports:** Shows active or listening ports

```cmd
     netstat -pnltu
```

5.  **Find information about domain:** `whois` command is used to find out information about a domain, such as the owner of the domain, the owner’s contact information, and the nameservers used by domain.

```cmd
    whois [domain]

    Example:
    whois google.com
```

**[⬆ Back to Top](#table-of-contents)**

### Installing packages

1. **Install package:**

```cmd
yum install package_name
```

2. **Package description:**
The info command is used to display brief details about a package.

```cmd
yum info package_name
```

3. **Uninstall package:**
The remove command is used to remove or uninstall package name.
```cmd
yum remove package_name
```
4. **Install package from local file:**

It is also possible to install package from local file named package_name.rpm.

```cmd
rpm -i package_name.rpm
```

5. **Install from source code:**

```cmd
tar zxvf sourcecode.tar.gz
cd sourcecode
./configure
make
make install
```

**[⬆ Back to Top](#table-of-contents)**

## Disk usage

1.  **Synopsis:** `du` command is used to check the information of disk usage of files and directories on a machine

```cmd
du [OPTION]... [FILE]...
```

2.  **Disk usage of a directory:** To find out the disk usage summary of a /home/ directory tree and each of its sub directories

```cmd
du  /home/
```

3.  **Disk usage in human readable format:** To find out the disk usage in human readable format

```cmd
du  -h /home/
```

4.  **Total disk usage of a directory:** To find out the total disk usage

```cmd
du  -sh /home/
```

5.  **Total disk usage of all files and directories:** To find out the total disk usage of files and directories

```cmd
du  -ah /home/
```

6.  **Total disk usage of all files and directories upto certain depth:** print the total for a directory only if it is N or fewer levels below the command

```cmd
du  -ah --max-depth 2 /home/
```

7.  **Total disk usage with excluded files:** To find out the total disk usage of files and directories, but excludes the files that matches given pattern.

```cmd
du -ah --exclude="*.txt" /home/
```

8.  **Help:** This command gives information about `du`

```cmd
du  --help
```

**[⬆ Back to Top](#table-of-contents)**

## System and Hardware information

1.  **Print all information**: `uname` is mainly used to print system information.

```bash
$ uname -a
```

2.  **Print kernel name**:

```bash
$ uname -s
```

3.  **Print kernel release**:

```bash
$ uname -r
```

4.  **Print Architecture**:

```bash
$ uname -m
```

5.  **Print Operating System**:

```bash
$ uname -o
```

**[⬆ Back to Top](#table-of-contents)**

## Search Files

1. **Pattern search:**
The `grep` command is used to search patterns in files.

```cmd
grep pattern files
grep -i // Case sensitive
grep -r // Recursive
grep -v // Inverted search

Example:
grep "^hello" test.txt // Hello John
grep -i "hELLo" text.txt // Hello John
```

2. **Find files and directories:**

The `find` command is used to find or search files and directories by file name, folder name, creation date, modification date, owner and permissions etc and perform subsequent operations on them.

i. **Search file with name:**

```cmd
find ./directory_name -name file_name

Example:
find ./test -name test.txt // ./test/test.txt
```

ii. **Search file with pattern:**

```cmd
find ./directory_name -name file_pattern

Example:
find ./test -name *.txt // ./test/test.txt
```

iii. **Search file with executable action:**

```cmd
find ./directory_name -name file_name -exec command

Example:
find ./test -name test.txt -exec rm -i {} \; // Search file and delete it after confirmation
```

iv. **Search for empty files or directories:**

The find command is used to search all empty folders and files in the entered directory or sub-directories.

```cmd
find ./directory_name -empty

Example:
find ./test -empty
//./test/test1
//./test/test2
//./test/test1.txt
```

v. **Search for files with permissions:**

The find command is used to find all the files in the mentioned directory or sub-directory with the given permissions

```cmd
find ./directory_name -perm permission_code

Example:
find ./test -perm 664
```

vi. **Search text within multiple files:**

```cmd
find ./ -type f -name file_pattern -exec grep some_text  {} \;

Example:
find ./ -type f -name "*.txt" -exec grep 'World'  {} \; // Hello World
```

3. **Whereis to locate binary or source files for a command:**
The whereis command in Linux is used to locate the binary, source, and manual page files for a command. i.e, It is used to It is used to find executables of a program, its man pages and configuration files.

```cmd
whereis command_name

Example:
whereis netstat //netstat:  /bin/netstat /usr/share/man/man8/netstat.8.gz(i.e, executable and location of its man page)
```

4. **Locate to find files:**
The locate command is used to find the files by name. This command is faster compared to find command because it searches database for the filename instead of searching your filesystem.

```cmd
locate [OPTION] PATTERN

Example:
locate "*.txt" -n 10 // 10 file search results ending with .txt extension
```

**[⬆ Back to Top](#table-of-contents)**

## SSH

SSH (Secure Shell) is a network protocol that enables secure remote connections between two systems.

1.  **Connect remote machine using IP address or machine name:** The remote server can be connected with local user name using either host name or IP address

```cmd
ssh <host-name> or <ip-address>

Example:
ssh 192.111.66.100
ssh test.remoteserver.com
```

2.  **Connect remote machine using username:** It is also possible specify a user for an SSH connection.

```cmd
ssh username@hostname_or_ip-address

Example:
ssh john@192.0.0.22
ssh john@test.remoteserver.com
```

3.  **:Connect remote machine using custom port** By default, the SSH server listens for a connection on port 22. But you can also specify the custom port.

```cmd
ssh <host-name> or <ip-address> -p port_number

Example:
ssh test.remoteserver.com -p 3322
```

4.  **Generate SSH keys using keygen:** SSH Keygen is used to generate a key pair which consists of public and private keys to improve the security of SSH connections.

```cmd
ssh-keygen -t rsa
```

5.  **Copying SSH keys to servers:** For SSH authentication, `ssh-copy-id` command will be used to copy public key(id_rsa.pub) to server.

```cmd
ssh-copy-id hostname_or_IP
```

6.  **Copy a File Remotely over SSH:** SCP tool is used to securely copy files over the SSH protocol.

```cmd
scp fileName user@remotehost:destinationPath

Example:
scp test.txt test@10.0.0.64:/home/john/Desktop
```

7.  **Edit SSH Config File** SSH server options customized by editing the settings in `sshd_config` file.

```cmd
sudo vim /etc/ssh/sshd_config
```

8.  **Run commands on a remote server** SSH commands can be executed on remote machine using the local machine.

```cmd
ssh test.remoteserver.com mkdir NewDirectoryName // Creating directory on remote machine
```

9.  **Restart SSH service:** You need to restart the service in Linux after making changes to SSH configuration.

```cmd
sudo ssh service restart
(or)
sudo sshd service restart
```

**[⬆ Back to Top](#table-of-contents)**

## Vi-Vim-commands

Vi editor is the most popular text editor from the early days of Unix. Whereas Vim(Vi IMproved) is an improved version of vi editor to be used in CLI (command line interface) for mainly text editing tasks in many configuration files. Some of the other alternatives are Elvis, Nvi, Nano, Joe, and Vile.
It has two main operation modes,

1.  **Command Mode:** It allows the entry of commands to manipulate text.
2.  **Entry mode(Or Insert mode):** It allows typed characters on the keyboard into the current file.

#### 1. Start with Vi Editor

You can create a new file or open an existing file using `vi filename` command.

```cmd
 vi <filename_NEW> or <filename_EXISTING> // Create a new file or open an existing file

 Example:
 vi first.txt
```

Let's see how do you create file, enter the content and leave the CLI by saving the changes.

1.  Create a new file named `first.txt`
2.  Press `i` to enter the insert mode
3.  Enter the text "Hello World!"
4.  Save the text and exit by pressing `:wq!` command
5.  Check the entered text

#### 2. Cursor movement

    These commands will be used in Command mode.

##### Move cursor

You can use arrow keys(left, right, up and down) to move the cursor on the terminal. But you can also other keys for this behavior.

```cmd
 h        # Move left
 j        # Move down
 k        # Move up
 l        # Move right
```

##### Jump one word

These commands used to jump one word at a time

```cmd
w        # Jump forwards to the start of a word
W        # Jump forwards to the start of a WORD
e        # Jump forwards to the start of a word
E        # Jump forwards to the start of a WORD
b        # Jump backwords to the start of a word
B        # Jump backwords to the start of a WORD
```

##### Jump to start or end of a line or next line

These commands used to jump starting or ending of a line or a next line.

```cmd
^        # Jump to the start of a current line
$        # Jump to the end of a current line
return   # Jump to the start of a next line
```

##### Move sides

These commands used to moves all sides of the screen

```cmd
Backspace # Move cursor one character to the left
Spacebar  # Move cursor one character to the right
H(High)   # Move cursor to the top of the screen
M(Middle) # Move cursor to the middle of the screen
L(Low)    # Move cursor to the bottom of the screen
```

##### Paging and Scrolling

Paging is used to moves the cursor up or down through the text a full screen at a time. Whereas Scrolling happens line by line.

```cmd
Ctrl + f     # move forward one full screen
Ctrl + b     # move backward one full screen
Ctrl + d     # move forward half a screen
Ctrl + u     # move backward half a screen
```

##### Inserting Text

These commands places vi in entry mode from command mode. First, you need to be in command mode to use the below commands.

###### Insert

```cmd
i    # Insert text to the left of the cursor
I    # Insert text at the beginning of a line
ESC  # Exit insert mode
```

###### Append

```cmd
a    # Insert(or Append) text to the right of the cursor
A    # Insert(or Append) text at the end of a line
```

###### Open a line

```cmd
o    # Open a line below the current cursor position
O    # open a line above the current cursor position
```

##### Editing Text

1. **Change word:** Change word/part of word to right of cursor

```cmd
    cw
```

2. **Change line** Change entire line

```cmd
    cc
```

3. **Change line from specific character** Change from cursor to end of line

```cmd
    C
```

##### Deleting Text

1. **Deleting One Character:** Position the cursor over the character to be deleted and type x

```cmd
    x
    X       //To delete one character before the cursor
```
2. **Deleting a Word:** Position the cursor at the beginning of the word and type dw

```cmd
    dw
```
3. **Deleting a Line:** Position the cursor anywhere on the line and type dd.

```cmd
    dd
```

##### Cut, Copy & Paste

   Copy, Cut and Paste operations can be done in either Normal or visual Mode.

1. **Normal mode:** This mode appears on click of `Esc` key.

   **Copy** There are various copy or yank commands based on amount of text to be copied. The `y` character is used to perform this operation.

   i. Copy an entire line: Just place the cursor at the beginning of the line and type `yy`

```cmd
   yy
```

   ii.Copy three lines: Just place the cursor from where to start copying and type `3yy`

```cmd
   3yy
```

   iii. Copy word with trailing whitespace: Place the cursor at the beginning of the word and type `yaw`

```cmd
   yaw
```

   iv. Copy word without trailing whitespace: Place the cursor at the beginning of the word and type `yiw`.

```cmd
   yiw
```

   v. Copy right of the cursor: Copy text right of the cursor to the end of line using `y$` command

```cmd
   y$
```

   vi.Copy left of the cursor: Copy text left of the cursor to the end of line using `y^` command

```cmd
   y^
```

   vii. Copy text between the cursor and character: Copy text between the cursor and specified character.

```cmd
   ytx(Copy until x and x is excluded)
   yfx(Copy until x and x is included)
```

   **Cut** There are various cutting or deleting commands based on amount of text to be deleted. The `d` character is used to perform this operation.

   i. Cut entire line: Cut the entire line where the cursor is located

```cmd
   dd
```

   ii.Cut three lines: Cut the three lines starting from the place where cursor is located

```cmd
   3dd
```

   iii.Cut right of the cursor: Cut the text from the right of the cursor till the end of line

```cmd
   d$
```

   iii.Cut left of the cursor: Cut the text from the left of the cursor till the beginning of line

```cmd
   d^
```

   **Paste** This operation is performed using `p` command to paste the selected text

```cmd
   p
```

2. **Visual Mode** In this mode, first select the text using below keys

    1. v (lowercase): To select individual characters
    2. V (uppercase): To select the entire line
    3. Ctrl+v: To select by block

    and perform copy, cut and paste operations using y,d and p commands

##### Exiting

    These commands are used to exit from the file.
```cmd
    :w	    # Write (save) the file, but don't exit
    :wq	    # Write (save) and quit
    :wq!	# Force write (save) and quit
    :q	    # Quit, but it fails if anything has changed
    :q!	    # Quit and throw away for any changes
```

**[⬆ Back to Top](#table-of-contents)**

## Extra-commands

### Linux Basic Commands

The default prompt for regular user is **$** and for root user is **#**

Ex: 

    [siva@siva-mint ~]$
    [siva@siva-mint ~]#

#### How to determine whether a given Linux is 32 bit or 64 bit?**

`$ uname -m`

    x86_64 ==> 64-bit kernel
    i686   ==> 32-bit kernel

* Check Linux OS
![image](https://user-images.githubusercontent.com/69948118/232764043-a6132a7d-40c4-4daa-a791-2238c90b0719.png)


#### Show distribution info:**

`$ uname -a`

    Linux localhost.localdomain 4.5.7-300.fc24.x86_64 #1 SMP Wed Jun 8 18:12:45 UTC 2016 x86_64 x86_64 x86_64 GNU/Linux

Getting Help on commands:

    $ man pwd
    $ info pwd
    $ help pwd

Go to home to home directory: `$ cd ~`

How much time it took to execute the command: `$ time pwd`

To find out where a particular command is taken from:

    $ type bash
    bash is /bin/bash

**type** command to check built-in or external command

    $ type pwd
    pwd is a shell builtin

    $ type bash
    bash is /bin/bash

To see the executed command history: `$ history`

To execute 23rd command: `$ !23`

To execute last command: `$ !!`

To edit history command by number, opens in VI: `$ fc 12`

To runs the most recent command that contains a particular string of characters: `$ !?string?`

To show current user:

    $ who am i
    siva     pts/0        2016-08-22 10:26 (192.168.56.1)

`$ grep siva /etc/passwd`

    siva:x:1000:1000:Siva:/home/siva:/bin/bash


`$ hostname`
    siva-centos7

ls command:

    $ ls -al
    $ ls --help
    $ ls --hide=Desktop

`$ date`

    Mon Aug 22 10:33:50 IST 2016

`$ date +'%d/%m/%y'`

    22/08/16

`$ date +'%A, %B %d, %Y'`

    Tuesday, October 21, 2014

`date --help`

`$ id`

    uid=1000(siva) gid=1000(siva) groups=1000(siva),10(wheel) context=unconfined_u:unconfined_r:unconfined_t:s0-s0:c0.c1023

See which users logged into the system currently

    $ who -uH
    NAME     LINE         TIME             IDLE          PID COMMENT
    siva     :0           2016-08-22 10:11   ?          2575 (:0)
    siva     tty2         2016-08-22 10:12 00:29        3443
    siva     pts/0        2016-08-22 10:26   .          3935 (192.168.56.1)

List all aliases: `$ alias`

If a command is not in your PATH variable: `$ locate chage`

### Terminal shorcuts

    Alt+F => Word forward Go forward one word.
    Alt+B => Word backward Go backward one word.
    Ctrl+A => Beginning of line Go to the beginning of the current line.
    Ctrl+E => End of line Go to the end of the line.
    Ctrl+L => Clear screen Clear screen and leave line at the top of the screen.

    Alt+U => Uppercase word Change the current word to uppercase.
    Alt+L => Lowercase word Change the current word to lowercase.
    Alt+C => Capitalize word Change the current word to an initial capital

### Alias

``` bash
alias sai='sudo apt-get install'
unalias sai
```

For all users

    /etc/profile
    /etc/bashrc

User specific config files

    ~/.bash_profile
    ~/.bashrc
    ~/.bash_logout

To reload config file: `$ source ~/.bashrc`

### touch command

    $ touch memo{1,2,3,4,5}
    $ ls
    memo1 memo2 memo3 memo4 memo5

    $ touch {John,Bill,Sally}-{Breakfast,Lunch,Dinner}
    $ ls
    Bill-Breakfast Bill-Lunch John-Dinner Sally-Breakfast Sally-Lunch
    Bill-Dinner John-Breakfast John-Lunch Sally-Dinner

    $ rm -f {John,Bill,Sally}-{Breakfast,Lunch,Dinner}

    $ touch {a..f}{1..5}
    $ ls
    a1 a3 a5 b2 b4 c1 c3 c5 d2 d4 e1 e3 e5 f2 f4
    a2 a4 b1 b3 b5 c2 c4 d1 d3 d5 e2 e4 f1 f3 f5

### ls command

    $ ls -l
    total 4
    -rw-rw-r--. 1 joe joe 0 Dec 18 13:38 apple
    lrwxrwxrwx. 1 joe joe 5 Dec 18 13:46 pointer_to_apple -> apple
    -rwxr-xr-x. 1 joe joe 0 Dec 18 13:37 scriptx.sh

To show hidden and non-hidden files:: `$ ls -a`

To list all files by time most recently modified: `$ ls -at`

To list files and append file-type indicators: `$ ls -F`

`$ ls --hide=g*`

`$ ls -ld $HOME/test/`

To list all files and directories recursively from current directory down: `$ ls -R`

To list files by size: `$ ls -S`

### Permissions

First character of permission:

    hyphen (-) : a regular file
    d : a directory
    l ( lowercase L) : a symbolic link
    b (for a block device)
    c (for a character device)
    s (for a socket)
    p (for a named pipe)
    x: an executable file (a script or binary file that runs as a command)

Changing permissions with chmod (numbers)

each permission (read, write, and execute) is assigned a number

r=4, w=2, and x=1

For example, to make permissions wide open for yourself as owner, 
you would set the first number to 7 (4+2+1), and then you would give the group and others read-only
permission by setting both the second and third numbers to 4 (4+0+0), so that the final
number is 744.

    # chmod 777 file -> rwxrwxrwx
    # chmod 755 file -> rwxr-xr-x
    # chmod 644 file -> rw-r--r-
    # chmod 000 file -> ---------

All files and directories below, and including, the myapps directory

    $ chmod -R 755 $HOME/myapps

Changing permissions with chmod (letters)

user (u), group (g), other (o),all users (a).
read (r), write (w), and execute (x)

Current : (rwxrwxrwx).

    $ chmod a-w file -> r-xr-xr-x
    $ chmod o-x file -> rwxrwxrw-
    $ chmod go-rwx file -> rwx------

Current: (---------).

    $ chmod u+rw files -> rw-------
    $ chmod a+x files -> --x--x--x
    $ chmod ug+rx files -> r-xr-x---
    $ chmod -R o-w $HOME/myapps

Changing file ownership

    # chown joe /home/joe/memo.txt
    # ls -l /home/joe/memo.txt
    -rw-r--r--. 1 joe root 0 Dec 19 11:23 /home/joe/memo.txt

To change group as well

    # chown joe:joe /home/joe/memo.txt
    # ls -l /home/joe/memo.txt
    -rw-r--r--. 1 joe joe 0 Dec 19 11:23 /home/joe/memo.txt

    # chown -R joe:joe /media/myusb

Moving, Copying, and Removing Files

    $ mv abc def
    $ mv abc ~
    $ mv /home/joe/mymemos/ /home/joe/Documents/


    $ cp abc def
    $ cp abc ~
    $ cp -r /usr/share/doc/bash-completion* /tmp/a/
    $ cp -ra /usr/share/doc/bash-completion* /tmp/b/

    $ rm abc
    $ rm *
    $ rmdir /home/joe/nothing/
    $ rm -r /home/joe/bigdir/
    $ rm -rf /home/joe/hugedir/

The backslash causes any command to run unaliased.

    \rm bigdir

### VIM

    0 (zero) — Moves the cursor to the beginning of the current line.
    $ Moves the cursor to the end of the current line.

    ZZ — Saves the current changes to the file and exits from vi.
    :w — Saves the current file but doesn't exit from vi.
    :wq — Works the same as ZZ.
    :q — Quits the current file. This works only if you don’t have any unsaved changes.
    :q! — Quits the current file and doesn’t save the changes you just made to the file.

`$ locate .bashrc`

    /etc/skel/.bashrc
    /home/cnegus/.bashrc

`# locate .bashrc`

    /etc/skel/.bashrc
    /home/bill/.bashrc
    /home/joe/.bashrc
    /root/.bashrc

### find command

`# find /etc -name passwd`

    /etc/pam.d/passwd
    /etc/passwd

`# find /etc -iname '*passwd*'`

    /etc/pam.d/passwd
    /etc/passwd-
    /etc/passwd.OLD
    /etc/passwd
    /etc/MYPASSWD
    /etc/security/opasswd

Finding files by size

    $ find /usr/share/ -size +10M
    $ find /mostlybig -size -1M
    $ find /bigdata -size +500M -size -5G -exec du -sh {} \;
    4.1G /bigdata/images/rhel6.img
    606M /bigdata/Fedora-16-i686-Live-Desktop.iso
    560M /bigdata/dance2.avi

Finding files by user

    $ find /home -user chris -ls
    # find /home -user chris -or -user joe -ls
    # find /etc -group ntp -ls
    # find /var/spool -not -user root -ls

Finding files by permission

    $ find /bin -perm 755 -ls
    $ find /home/chris/ -perm -222 -type d -ls
    $ find /myreadonly -perm +222 -type f
    $ find . -perm -002 -type f -ls

Finding files by date and time

changed in past 10 minutes: `$ find /etc/ -mmin -10`

changed in the past three days: `$ find /bin /usr/bin /sbin /usr/sbin -ctime -3`

have not been accessed in more than 300 days: `$ find /var/ftp /var/www -atime +300`

The time options (-atime, -ctime, and -mtime)  based on the number of days

The min options (-amin, -cmin, and -mmin) do the same in minutes.

$ find /etc -iname iptables -exec echo "I found {}" \;

    I found /etc/bash_completion.d/iptables
    I found /etc/sysconfig/iptables

$ find /usr/share -size +5M -exec du {} \; | sort -nr

$ find /var/allusers/ -user joe -ok mv {} /tmp/joe/ \;

-ok asks for confirmation

### grep command

    $ grep desktop /etc/services
    $ grep -i desktop /etc/services

To search for lines that don’t contain a selected text string, use the -v option.

    $ grep -vi tcp /etc/services

-r : recursively

-l : list filenames only

$ grep -rli peerdns /usr/share/doc/

$ ip addr show | grep inet


### SSH Password-less login

1. Install OpenSSH on Server

ex: sudo apt-get install openssh-server
    sudo service ssh restart (or) sudo systemctl start ssh

2. On client machine, generate ssh keys

  ssh-keygen -t rsa

  Copy public key (id_rsa.pub) from client machine to server's authorized_keys.

  ssh-copy-id <username>@<ssh-server-ip>

  ssh-copy-id siva@192.168.0.103

  Now you can ssh without requiring to enter password:
  ssh siva@192.168.0.103

Note: Check configuration of SSH server in /etc/ssh/sshd_config file.

### All Commands 
![image](https://user-images.githubusercontent.com/69948118/232765171-aae1830f-477f-4802-af3c-a4a01843ef39.png)
