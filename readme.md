
## study of ketonix/usb java api  

### discovery

basic `lsusb` report
```
Bus 001 Device 028: ID 04d8:f453 Microchip Technology, Inc. 
```

make ketonix/usb readable on connect
* http://counterinception.com/content/ketosis-trackers

```
sudo cat > /etc/udev/rules.d/70-ketonix.rules << EOF
SUBSYSTEM=="usb", ATTR{idVendor}=="04d8", ATTRS{idProduct}=="f453", MODE="0666"
EOF
sudo udevadm control --reload-rules
```

enumerate hid devices with `purejavahidapi`
* https://github.com/nyholku/purejavahidapi/blob/master/example/Example1.java

```
VID = 0x04D8 PID = 0xF453 Manufacturer = null Product = KETONIX AB Ketonix 2015 Path = /sys/devices/pci0000:00/0000:00:14.0/usb1/1-1/1-1.4/1-1.4:1.0/0003:04D8:F453.000E/hidraw/hidraw5
```

### interface

