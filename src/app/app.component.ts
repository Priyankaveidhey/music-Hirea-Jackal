import { Component, OnInit, AfterViewInit } from '@angular/core';
import { RestService } from './rest.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, AfterViewInit {
  starsCount1: number;
  starsCount2: number;
  starsCount3: number;
  starsCount4: number;
  starsCount5: number;
  title = 'app';
  genreName: any;
  musicTrack: any;
  optionsSelect: Array<any>;
  musicTrackDetails: any;
  musicGenreDetails: any;
  genreNameSelect: any = [];

  ngOnInit() {
    this.starsCount1 = 4;
    this.starsCount2 = 3;
    this.starsCount3 = 2;
    this.starsCount4 = 3;
    this.starsCount5 = 1;

    this.genreName = {
      id: "",
      name: ""
    };

    this.musicTrack = {
      id: "",
      name: "",
      genreName: "",
      rating: "",
    };

  }

  ngAfterViewInit() {

  }

  constructor(public rest: RestService) {

    var that = this;
    this.musicGenreDetails = [];
    this.rest.getGenre().subscribe((data) => {
      console.log(data);
      that.genreNameSelect = new Array<any>;
      this.musicGenreDetails = data;
      for (var i = 0; i < data.length; i++) {
        var temp = { value: "", label: "" };
        temp.label = data[i].name;
        temp.value = data[i].id;
        that.genreNameSelect.push(temp);
      }
    });

    this.musicTrackDetails = [];
    this.rest.getTracks().subscribe((data: {}) => {
      console.log(data);
      this.musicTrackDetails = data;
    });
  }

  getTracks() {
    this.musicTrackDetails = [];
    this.rest.getTracks().subscribe((data: {}) => {
      console.log(data);
      this.musicTrackDetails = data;
    });
  }
  getGenres() {
    this.musicGenreDetails = [];
    this.rest.getGenre().subscribe((data: {}) => {
      console.log(data);
      this.musicGenreDetails = data;
    });

  }
  addGenre() {

    console.log(this.genreName.name);
    var that = this;
    this.rest.addGenre(that.genreName).subscribe((result) => {
      console.log("success" + result);
    }, (err) => {
      console.log(err);
    });
    $("#addGenreModal").find('.close').click();
  }

  addTrack() {
    console.log(this.musicTrack.name);
    this.rest.addTrack(this.musicTrack).subscribe((result) => {
      console.log("success" + result);
    }, (err) => {
      console.log(err);
    });
    console.log(this.musicTrack);
    $("#addMusicTrackModal").find('.close').click();
  }

  updateTrack(id) {

  }

  deleteTrack(id) {
    this.rest.deleteTrack(id)
      .subscribe(res => {
        this.getTracks();
      }, (err) => {
        console.log(err);
      }
      );

  }
  updateGenre(id) {
      musicgenre.show();
  }
  deleteGenre(id) {
    this.rest.deleteGenre(id)
      .subscribe(res => {
        this.getGenres();
      }, (err) => {
        console.log(err);
      }
      );
  }
}
