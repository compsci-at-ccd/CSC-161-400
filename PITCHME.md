---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-108554.jpg

## Computer Science II

### Lecture 7

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-108554.jpg

### Special Section: Virtualization and the Cloud
We talked last time about the benefits of virtualization: from virtual machines, containers to the OS.  We installed VirtualBox on our development machines, and ran Ubuntu within it.  Today we will work a bit with Docker, a container engine, and create a workstation on the cloud.

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg

### Containers and Docker
"...a lightweight, stand-alone, executable package of a piece of software that includes everything needed to run it: code, runtime, system tools, system libraries, settings."

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg
### Install Docker and run our "Hello world!"
-Install from the web, [Docker CE](https://www.docker.com/community-edition)
- Windows: run cmd as Administrator, "docker run hello-world"
- macOS/Linux: in terminal, "sudo docker run hello-world"

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg
### How about something useful?
Create an NGinx instance:
- sudo docker run --name nginx-raw -p 80:80 nginx

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg
### How about something *more* useful?
Create an NGinx instance, with our own webpage
- create a directory, and put a test.html in it
- sudo docker run -v **path-to-folder**:/usr/share/nginx/html:rw -p 80:80 -d nginx
 - clever?

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg
### A few things to help
- sudo docker stop (stop a docker container)
- sudo docker ps -a (see what processes there are)
- sudo docker rm <number> (remove a process)

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg
### Similar projects
- rkt and CoreOS (Google)
- lxd and Canonical

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Make an Ubuntu Workstation, on Google Cloud Platform
1. You should have already created an account.
1. Create a VM instance, using the server version of Ubuntu
1. Configure access
1. Configure the instance
1. Configure yourself
1. Connect

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Create a VM instance, using the server version of Ubuntu
- console.cloud.google.com, in VM instances
- [walkthrough in class]

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Configure access
- configure the firewall to allow vnc-server on 5901
- put a network tag for "vnc-server"
- Do you have a VNC remote access? RealVNC? TightVNC?

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Configure the instance - install desktop
- sudo apt-get update
- sudo apt-get upgrade
- sudo apt-get install gnome-shell
- sudo apt-get install ubuntu-gnome-desktop
- sudo apt-get install autocutsel

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Configure the instance - install VNC Server
- sudo apt-get install tightvncserver
- touch ~/.Xresources

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Configure the instance - install GNOME
- sudo apt-get install gnome-core
- sudo apt-get install gnome-panel
- sudo apt-get install gnome-themes-standard
- sudo apt-get install adwaita-icon-theme-full adwaita-icon-theme
- gsettings set org.gnome.metacity theme 'Adwaita'

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Configure the instance - starting and stopping vncserver
- vncserver -geometry 1024x768
- vncserver -kill :1

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Configure the instance - configure VNC parameters
In /home/**user**/.vnc/xstartup:
```bash
#!/bin/sh

autocutsel -fork
xrdb $HOME/.Xresources
xsetroot -solid grey
#
# Leave x-terminal and x-window routines commented
#
export XKL_XMODMAP_DISABLE=1
export XDG_CURRENT_DESKTOP="GNOME-Flashback:Unity"
export XDG_MENU_PREFIX="gnome-flashback-"
unset DBUS_SESSION_BUS_ADDRESS
#/etc/X11/Xsession - comment this line out!
gnome-session --session=gnome-flashback-metacity --disable-acceleration-check --debug &
```
