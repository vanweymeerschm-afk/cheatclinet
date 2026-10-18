# Marthox PvP Client — starter project

Target: Minecraft Java 1.21.11, Fabric, Java 21.

This is a **source starter project**, not a finished ESP client or a compiled JAR. It registers three client keybind toggles:
- `G` — chunk-info toggle
- `H` — visible-storage-info toggle
- `J` — visible-player-info toggle

The toggles are scaffolding only; rendering/highlighting has not yet been implemented. It does not scan hidden storage, reveal hidden players, or implement anti-cheat bypasses.

## Build the mod JAR

1. Install Java 21.
2. Install Gradle 8.12 or newer.
3. Open a terminal in this folder.
4. Run `gradle build` (or `./gradlew build` if you add the Gradle wrapper).
5. The built JAR will be in `build/libs/`.

The first build needs internet access to download Minecraft/Fabric dependencies. If the selected Fabric versions are no longer available, update the version properties using the official Fabric example-mod template for Minecraft 1.21.11.


## Build on GitHub Actions

1. Upload/push this whole project to a GitHub repository (keep the `.github/workflows/build.yml` file).
2. Open the repository's **Actions** tab.
3. Select **Build MarthoxPvPClient** and click **Run workflow**, or push a commit to `main`/`master`.
4. When the run finishes, open the successful workflow run and download the **MarthoxPvPClient-jar** artifact.

The workflow uses Java 21 and runs `gradle build`. If the build fails because a Minecraft/Fabric dependency version cannot be resolved, update the version values in `gradle.properties` to compatible published versions and run the workflow again.
