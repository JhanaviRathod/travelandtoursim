import { Injectable } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { FileHandle } from './_model/file-handle-model';
import { Package } from './_model/package.model';

@Injectable({
  providedIn: 'root'
})
export class ImageProcessingService {

  constructor(private sanitizer : DomSanitizer) { }


  public createImages(pack : Package){
    const packageImages : any[] = pack.packageImages;

    const packageImagesToFileHandel : FileHandle[] = [];

    for(let i = 0; i < packageImages.length; i++){
      const imageFileData = packageImages[i];

      const imageBlob = this.dataURItoBlob(imageFileData.picbyte, imageFileData.type);

      const imageFile = new File([imageBlob], imageFileData.name, {type: imageFileData.type} );

      const finalFileHandle : FileHandle = {
        file : imageFile,
        url : this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
      };
      packageImagesToFileHandel.push(finalFileHandle);
    }
    pack.packageImages = packageImagesToFileHandel;
    return pack;
  }

  public dataURItoBlob(picBytes: any, imageType: any){
    const byteString = window.atob(picBytes);
    const arrayBuffer = new ArrayBuffer(byteString.length);
    const int8Array = new Uint8Array(arrayBuffer);
    for(let i = 0; i < byteString.length; i++){
      int8Array[i] = byteString.charCodeAt(i);
    }
    const blob = new Blob([int8Array], {type : imageType});
    return blob;
  }
  // public createImages(pack : Package){
  //   const packageImages : any[] = pack.packageImages;

  //   const packageImagesToFileHandel : FileHandle[] = [];
  //   for(let i = 0; i < packageImages.length; i++){ 

  //     const imageFileData = packageImages[i];

  //     const imageBlob = this.dataURItoBlob(imageFileData.picbyte, imageFileData.type);

  //     const imageFile = new File([imageBlob], imageFileData.name, {type : imageFileData.type});

  //     const finalFileHandle : FileHandle = {
  //       file : imageFile,
  //       url : this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
  //     };
  //     packageImagesToFileHandel.push(finalFileHandle);
  //   }

  //   pack.packageImages = packageImagesToFileHandel;
  //   return pack;
  // }

  // public dataURItoBlob(picbyte : any, imageType: any){
  //   const byteString = window.atob(picbyte);
  //   const arrayBuffer = new ArrayBuffer(byteString.length);
  //   const int8Array = new Uint8Array(arrayBuffer);

  //   for(let i =0; i < byteString.length; i++){
  //     int8Array[i] = byteString.charCodeAt(i);
  //   }

  //   const blob = new Blob([int8Array], {type: imageType});
    
  //   return blob ;
  // }
}
