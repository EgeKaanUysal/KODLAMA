
# Kullanıcıdan string girişi al
giriş = input("Bir string girin: ")

# Her karakter için sayıya çevir (ASCII değerleri)
sayılar = [ord(char) for char in giriş]
print(f"Her karakterin sayısı: {sayılar}")

# Sayıları byte'lara çevir
byte_verisi = bytes(sayılar)

