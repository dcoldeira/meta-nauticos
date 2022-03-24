# Nauticos

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
| Raspberry Pi 2 | aspberrypi2 |
| Raspberry Pi 3 | aspberrypi3 |
| Raspberry Pi 4 | aspberrypi4 |
| Raspberry Pi 4 64-bit| aspberrypi4-64 |
| Raspberry Pi 0 | aspberrypi0 |


```Bash
export MACHINE=raspberrypi_NUMBER && source ./setup-environment.sh
```

    
