---
layout: base.njk
title: Build Go from Source
description: Build Go from source, easy upgrading
---

# Building Golang from Source

Taking Golang's source code and building the Go compiler from it is something that I recently wanted to do. This guide will show you how to do it too!

## Why do this?

Some of you reading this will already be aware of the pros and cons of building your packages from source, so if you're already convinced, feel free to skip this section. Otherwise, let's quickly go over why you would want to do this...

### Pros
- Get a modern version of Go on systems that wouldn't typically have an up-to-date version. For example, I use Debian, which uses old and stable versions of programs, so the latest Go version is not always going to be provided through APT.
- Go is a very nice language to compile, being fast and easy to set up. This is a great intro into building from source.
- Easy version management. If all you need is one up-to-date version of Go, then this is a nice way to do this. Upgrading/downgrading becomes a case of running `git pull` and then rebuilding.
- Modify the source code. If you want to change how the Go compiler behaves, this is the easiest way to do it.

### Cons
- More setup.
- Doesn't solve the problem of using multiple versions of Golang on one PC. For this, look into solutions like Nix packages.

## Chicken and Egg

Go is written in, well, Go. This is common of mature platforms, but means we will need to download a built version of Go to compile the Go source code. Don't worry, though; we only need this temporarily, and can delete it after.

### Downloading a prebuilt Go compiler

Download a prebuilt Go compiler [here](https://go.dev/dl/). Download the latest archive for your OS and extract it.

Make sure the version you download meets the bootstrap requirements of the Go version you want to build. The official [Go source installation guide](https://go.dev/doc/install/source) explains the current requirements.

### Check out the Go source code

Navigate to where you want to store the source code and run the following command:

```bash
	git clone https://github.com/golang/go.git
cd go
```

### Build Go from source

Now run the following command, but replace `<PATH_TO_YOUR_DOWNLOAD>` with the path of the prebuilt Go folder you downloaded and extracted. This should be the root of the Go installation, containing the `bin` directory.

```bash
	cd src
	GOROOT_BOOTSTRAP=<PATH_TO_YOUR_DOWNLOAD> ./make.bash
```

If you already have a compatible Go installation available in your `PATH`, you can omit `GOROOT_BOOTSTRAP=<PATH_TO_YOUR_DOWNLOAD>` and simply run:

```bash
	./make.bash
```

Once the build finishes, the newly built Go toolchain will be available in the `bin` directory at the root of the source checkout. You can check it by running:

```bash
	../bin/go version
```

Congratulations! You've pulled yourself up by your bootstraps and built Go from source. You can now delete the prebuilt folder you downloaded, provided you don't need it for anything else.

To use your newly built Go installation, add the `bin` directory at the root of the source checkout to your `PATH`. Keep in mind that if you want to build a newer version of Go later, you'll need a compatible bootstrap compiler again if your existing installation doesn't meet the new version's requirements.

