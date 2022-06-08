# ITunes - Movie App

[![N|Solid](https://img.icons8.com/ios-glyphs/344/itunes.png)](https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/index.html)


[TR]: iTunes Search API kullanılarak kullanıcının iTunes platformunda yer alan Film, Müzik, Kitap, Uygulama gibi içeriklere ulaşması sağlanmaktadır.
[EN]: By using the iTunes Search API, the user is able to access content such as Movies, Music, Books, Applications on the iTunes platform.


## Özellikler / Features

- [TR]: Arama Ekranı ve İçerik Detay Ekranı olarak 2 ekrandan oluşmaktadır.
- [TR]: Arama ekranında :
    - [TR]: Search bar ve sonuçların grid yapısında listelenmiştir.
    - [TR]: Paging yapısının oluşturuldu (Her Scroll'da 2 item eklenerek devam etmektedir).
- [TR]: İçerik Detay Ekranında :
    - [TR]: Arama sonucunda gelen değerlere göre detay ekranı oluşturuldu.
------
- [EN]: It consists of 2 screens as Search Screen and Content Detail Screen.
- [EN]: On the search screen:
    - [EN]: Search bar and results are listed in grid structure.
    - [EN]: The paging structure has been created (continues by adding 2 items in each scroll).
- [EN]: On Content Detail Screen:
    - [EN]: Detail screen has been created according to the values obtained as a result of the search.

## Tech
* Mimari / Architectural Design
    - MVVM
    - Lifecycle
    - Navigation
    - ViewModel
* 3.Parti Kütüphaneler / 3rd Party Libraries
    - Retrofit 2
    - GSON
    - RxJava
    - Glide
    

## JSON
```sh
https://itunes.apple.com/search?term=inna&limit=1
```

```javascript
{
	"resultCount": 1,
	"results": [
		{
			"wrapperType": "track",
			"kind": "song",
			"artistId": 1473472668,
			"collectionId": 383342838,
			"trackId": 383348658,
			"artistName": "Degree",
			"collectionName": "Diwali",
			"trackName": "Inna",
			"collectionCensoredName": "Diwali",
			"trackCensoredName": "Inna",
			"collectionArtistId": 36270,
			"collectionArtistName": "Various Artists",
			"artistViewUrl": "https://music.apple.com/us/artist/degree/1473472668?uo=4",
			"collectionViewUrl": "https://music.apple.com/us/album/inna/383342838?i=383348658&uo=4",
			"trackViewUrl": "https://music.apple.com/us/album/inna/383342838?i=383348658&uo=4",
			"previewUrl": "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview125/v4/e3/9d/78/e39d7870-b22b-fadd-dc56-9449ad5d7598/mzaf_161015699950144031.plus.aac.p.m4a",
			"artworkUrl30": "https://is3-ssl.mzstatic.com/image/thumb/Music116/v4/2c/a7/3d/2ca73d08-1b61-b8f7-a0f8-aa22426a87c1/601811172766.jpg/30x30bb.jpg",
			"artworkUrl60": "https://is3-ssl.mzstatic.com/image/thumb/Music116/v4/2c/a7/3d/2ca73d08-1b61-b8f7-a0f8-aa22426a87c1/601811172766.jpg/60x60bb.jpg",
			"artworkUrl100": "https://is3-ssl.mzstatic.com/image/thumb/Music116/v4/2c/a7/3d/2ca73d08-1b61-b8f7-a0f8-aa22426a87c1/601811172766.jpg/100x100bb.jpg",
			"collectionPrice": 15.99,
			"trackPrice": 1.29,
			"releaseDate": "2002-05-21T12:00:00Z",
			"collectionExplicitness": "notExplicit",
			"trackExplicitness": "notExplicit",
			"discCount": 1,
			"discNumber": 1,
			"trackCount": 20,
			"trackNumber": 12,
			"trackTimeMillis": 192608,
			"country": "USA",
			"currency": "USD",
			"primaryGenreName": "Reggae",
			"isStreamable": true
		}
	]
}
```


#### İletişim / Contact

```sh
mail: isakulaksiz@outlook.com
```