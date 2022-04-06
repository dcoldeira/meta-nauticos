
# NauticOS

### [An small OS aiming to optimize marine navegation softwares targeting small single-board computers (SBCs) and the alike architectures...](https://github.com/dcoldeira/NauticOS)



## This is the Raspbery Pi build 

**Please be aware that this process can take very long time (days depending on your system..)**

Make sure you have installed the management tool `Repo` by Google, if not, as super root and assuming you are in a Debian distribution or derivative of some sort:

```Bash
apt install repo
```
Create a project directory (i.e mkdir My_Project) and cd into it, then:

```Bash
repo init -u git://code.qt.io/yocto/boot2qt-manifest -m v6.2.3.xml
```

Sync the repositories:

```Bash
repo sync
```
Then define what Raspberry Pi you have:

| Board      | MACHINE value |
| ----------- | ----------- |
| Raspberry Pi | raspberrypi |
| Raspberry Pi 2 | raspberrypi2 |
| Raspberry Pi 3 | raspberrypi3 |
| Raspberry Pi 4 | raspberrypi4 |
| Raspberry Pi 4 64-bit| raspberrypi4-64 |
| Raspberry Pi 0 | raspberrypi0 |


```Bash
export MACHINE=raspberrypi_NUMBER && source ./setup-environment.sh
```

This will not just create a sub directory `build-raspberrypi_NUMBER` but also reallocate you inside it. All corresponding configuration files of the project `bblayers.conf`,  `local.conf` and `templateconf.cfg` are in this directory.

    
Now you can build the full image by running the command:

```Bash
bitbake b2qt-embedded-qt6-image
```

This process will take ages as it compiles all the source code... Once all has compilated and built we can flash the image into a SD card. You can use the Raspberry Imager or bmap-tools. 



**To use the Raspberry Imager,** just download it `sudo apt install rpi-imager` and choose the `Use Custom` option and then inside Project_Name/build-raspberrypi_Number/tmp/deploy/raspberrypi_Number look for the corresponding wic.xz file that you can flash.

And **to use `bmap-tools`,** make sure it is installed

```Bash
sudo apt-get install -y bmap-tools
```

And then 

```Bash
sudo bmaptool copy b2qt-embedded-qt6-image-raspberrypi_NUMBER.wic.bz2 --bmap b2qt-embedded-qt6-image-raspberrypi_NUMBER.wic.bmap /dev/sda
bmaptool: info: block map format version 2.0
bmaptool: info: 687923 blocks of size 4096 (2.6 GiB), mapped 374929 blocks (1.4 GiB or 54.5%)
bmaptool: info: copying image 'b2qt-embedded-qt6-image-raspberrypi_NUMBER.wic.bz2' to block device '/dev/sda' using bmap file 'b2qt-embedded-qt6-image-raspberrypi_NUMBER.wic.bmap'
```
**Building the cross-compile SDK**


