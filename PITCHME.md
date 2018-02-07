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
Create an NGinx instance
- sudo docker run --name nginx-raw -p 80:80 nginx

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-427918.jpg
### How about something *more* useful?
Create an NGinx instance, with our own webpage
- create a directory, and put a test.html in it
- sudo docker run -v <path-to-folder:/usr/share/nginx/html:rw -p 80:80 -d nginx
 - clever?

---?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Make an Ubuntu Workstation, on Google Cloud Platform
1. You should have already created an account.
1. Create a VM instance, using the server version of Ubuntu
1. Configure access
1. Configure the instance
1. Configure yourself
1. Connect

+++?image=https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-91788.jpg
### Make an Ubuntu Workstation, on Google Cloud Platform
