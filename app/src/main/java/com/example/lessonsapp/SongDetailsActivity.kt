package com.example.lessonsapp
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SongDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_details)

        // Recupera os dados enviados
        val songTitle = intent.getStringExtra("songTitle") ?: "Título desconhecido"
        val songArtist = intent.getStringExtra("songArtist") ?: "Artista desconhecido"
        val songAlbum = intent.getStringExtra("songAlbum") ?: "Álbum desconhecido"
        val songImage = intent.getIntExtra("songImage", 0)

        // Log para verificar os dados
        Log.d("SongDetailsActivity", "Title: $songTitle, Artist: $songArtist, Album: $songAlbum, Image: $songImage")

        // Exibe os dados na UI
        findViewById<TextView>(R.id.tvSongTitle).text = songTitle
        findViewById<TextView>(R.id.tvSongArtist).text = songArtist
        findViewById<TextView>(R.id.tvSongAlbum).text = songAlbum

        // Verifica se a imagem é válida
        if (songImage != 0) {
            findViewById<ImageView>(R.id.ivSongImage).setImageResource(songImage)
        } else {
            // Defina uma imagem padrão ou esconda o ImageView
            findViewById<ImageView>(R.id.ivSongImage).setImageResource(R.drawable.default_image) // exemplo de imagem padrão
        }

        findViewById<Button>(R.id.btnStartLesson).setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
        }
    }
}
