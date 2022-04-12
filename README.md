

# NauticOS

NauticOS is a small Operating System aiming to optimize marine navegation softwares & hardwares to only include what is really needed onboard like the OpenCPN Chart Plotter Navigation, weather readers, SDR, sensor connections (air, SONAR, motor, exhaust, pressure, humidity, light, gas, smoke, batteries charge, tanks level, wind, switches etc), IoT and alike softwares and hardwares. It will be available for different architectures including but not limited to the Raspberry Pi and the Arduinos boards (ideally it will run on something smaller and even cheaper than those, hopefully). 

## There are two part of this project. 
- The desktop environment (NauticOS Desktop or GUI), and
- The image or builds of the Operative System

### **NauticOS Desktop Environment** 
A meta or Yocto layer called meta-nauticos hosted in this repo.  


### **NauticOS** 
The operating system needed to run the desktop environment and apps. These builds are collection of [layers](https://doc.qt.io/QtForDeviceCreation/b2qt-how-to-create-b2qt-image.html) baked and made with [The Yocto Project ](https://www.yoctoproject.org/)  aiming to use C++ for embeddeing. Images will be available to download as soon as they are ready for production. **Currently working on the Raspberry Pi build.**


    
