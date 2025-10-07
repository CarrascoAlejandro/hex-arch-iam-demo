#!/bin/bash
# Cleanup multiple JetBrains installations (IntelliJ, WebStorm, DataGrip)
# Keeps only specified versions

# === CONFIGURE THESE 3 VARIABLES (your current versions) ===
KEEP_IDEA="/home/alejandro/.local/share/JetBrains/Toolbox/apps/IDEA-U/ch-0/242.20224.22"
KEEP_WEBSTORM="/home/alejandro/.local/share/JetBrains/Toolbox/apps/WebStorm/ch-0/242.20224.18"
KEEP_DATAGRIP="/home/alejandro/.local/share/JetBrains/Toolbox/apps/DataGrip/ch-0/242.20224.22"

# === Typical install roots ===
SEARCH_PATHS=(
    "$HOME/.local/share/JetBrains/Toolbox/apps"
    "$HOME/.local/share/JetBrains"
    "/opt"
)

echo "🧹 Cleaning up JetBrains installations..."
for ROOT in "${SEARCH_PATHS[@]}"; do
  if [ -d "$ROOT" ]; then
    find "$ROOT" -maxdepth 4 -type d \( -iname "idea*" -o -iname "webstorm*" -o -iname "datagrip*" \) | while read -r dir; do
      if [[ "$dir" != "$KEEP_IDEA"* && "$dir" != "$KEEP_WEBSTORM"* && "$dir" != "$KEEP_DATAGRIP"* ]]; then
        echo "🚮 Removing $dir"
        rm -rf "$dir"
      else
        echo "✅ Keeping $dir"
      fi
    done
  fi
done

# === Remove duplicate launchers ===
echo "🧩 Cleaning up .desktop entries..."
for f in ~/.local/share/applications/*.desktop; do
  if grep -qiE "idea|webstorm|datagrip" "$f"; then
    KEEP_MATCH=false
    for k in "$KEEP_IDEA" "$KEEP_WEBSTORM" "$KEEP_DATAGRIP"; do
      if grep -q "$k" "$f"; then
        KEEP_MATCH=true
        break
      fi
    done
    if [ "$KEEP_MATCH" = false ]; then
      echo "🚮 Removing launcher: $f"
      rm "$f"
    fi
  fi
done

update-desktop-database ~/.local/share/applications
echo "✅ Cleanup complete!"
