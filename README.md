# NauticOS

## An small OS for skippers, boaters and sailors targeting small single-board computers (SBCs) and the alike architectures.


NauticOS is aiming to optimize softwares for boaters and only include what is really needed onboard like the OpenCPN Chart Plotter Navigation, weather, SDR, Sensor connections (air, SONAR, motor, exhaust, pressure, humidity, light, gas, smoke, batteries charge, tanks level, wind, switches etc), IoT and alike softwares and hardwares. It will be available for different architectures including but not limited to the Raspberry Pi and the Arduinos boards (ideally it will run on something smaller and even cheaper than those, hopefully).


NauticOS is built with [The Yocto Project ](https://www.yoctoproject.org/) and [boot2qt](https://doc.qt.io/QtForDeviceCreation/b2qt-how-to-create-b2qt-image.html) as it's aiming to use C++ for embeddeing.

## Images will be available as soon as they are ready for production. **NauticOS is Open Source**  and if you think you can help, please get touch/involved/pull request your ideas etc.. More to come.

## Builds 

**Currently working on the [Raspberry Pi build](https://doc.qt.io/QtForDeviceCreation/b2qt-how-to-create-b2qt-image.html)**

## For people wanting to get involved in the project:

Make sure you have installed the management tool `Repo` by Google, if not, as super root and assuming you are in a Debian distribution or derivative of some sort:

```Bash
apt install repo
```
Create a project directory and for a Qt 6.2 build:

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

This will not just create a sub directory `build-raspberrypi_NUMBER` but also reallocate you inside it. In this directory you will find the corresponding configuration files of the project `bblayers.conf`,  `local.conf` and `templateconf.cfg` inside the `/conf`, for this build we better change the following parameters inside `local.conf`:

```Bash
BB_NUMBER_THREADS ?= "1"
 
PARALLEL_MAKE ?= "-j1"
```

    
Safe your changes and let's build the full image:

```Bash
bitbake b2qt-embedded-qt6-image
```

This process will take ages as it compiles all the source code... Once all has compilated and built we can flash the image into a SD card, let's use `bmap-tools`:

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

