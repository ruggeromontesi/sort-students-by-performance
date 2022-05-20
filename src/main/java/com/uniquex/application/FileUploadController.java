package com.uniquex.application;

import java.io.IOException;
import java.util.stream.Collectors;

import com.uniquex.application.service.FileReadingService;
import com.uniquex.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {


   private final StorageService storageService;

   @Autowired
   private  StudentService studentService;


   private final FileReadingService fileReadingService;

   @Autowired
   public FileUploadController(StorageService storageService,StudentService studentService) {
      this.storageService = storageService;
      fileReadingService = new FileReadingService(studentService);
   }

   @GetMapping("/")
   public String listUploadedFiles(Model model) throws IOException {
      model.addAttribute("files",
            storageService.loadAll().map(path ->
                  MvcUriComponentsBuilder.fromMethodName(
                        FileUploadController.class,
                        "serveFile",
                        path.getFileName().toString())
                        .build().toUri().toString()).
                  collect(Collectors.toList()));
      return "uploadForm";
   }

   @GetMapping("/files/{filename:.+}")
   public ResponseEntity<Resource> serveFile(@PathVariable String filename){
      Resource file = storageService.loadAsResource(filename);
      return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; fileName = \"" + file.getFilename() + "\"" ).body(file);

   }

   @PostMapping("/")
   public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) {

      storageService.store(file);
      redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");

      return "redirect:/";
   }


   @GetMapping("/read")
   public String read(Model model) throws IOException {
      model.addAttribute("students", studentService.getStudents());

      return "studentUploadForm";
   }




   @PostMapping("/read")
   public String readFileUpload(@RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) {
      fileReadingService.readFile(file);

      storageService.store(file);

      redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");

      return "redirect:/read";
   }

   @PostMapping("/sort")
   public String sortStudents(Model model ) {
      studentService.sortStudents("mergeSort",false);
      model.addAttribute("students", studentService.getStudents());

      return "redirect:/read";
   }

   @PostMapping(value = {"/reset"})
   public String reset(Model model) {
      studentService.deleteAll();
      model.addAttribute("students", studentService.getStudents());
      return "redirect:/read";
   }

   @ExceptionHandler(StorageFileNotFoundException.class)
   public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
      return ResponseEntity.notFound().build();
   }

   public String ruggeroCreaNuovaDirectory() {
      return "Directory created";
   }

}