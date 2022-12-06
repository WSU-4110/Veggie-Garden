(SRS INFO): IntelliJ (Java) latest version, with Android Studio are the required apps to install on PC. 
Upon opening the file, you might have to "install the required JDK", which must be done (easy).
Running the app will just open through the emulator, and can be used!
We use the Pixel 2 API 33 for emulation.
If using AMD, enable SVM in BIOS and disable HyperV via cmd prompt. Start cmd in admin, and use this link for instructions: https://stackoverflow.com/questions/59549988/cant-install-android-emulator-for-amd-processors

If everything 'seems' fine, but it's not working, make sure to check these 3 things:
1. Sync Project With Gradle Files. Gradle is necessary to run this, and there's a button in the top right to do this, and 
    if it's not installed, a prompt should appear.
2. Rebuild the project. Top toolbar, build, rebuild. Wait until it's done and try again!
3. Lastly, check the LogCat (bottom left). Post any unfixable errors to our discussion board.
Enjoy!
