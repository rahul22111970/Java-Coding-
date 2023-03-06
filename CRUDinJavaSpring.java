@PostMapping("/students")
public Student createStudent(@RequestBody Student student) {
    return studentRepository.save(student);
}
@GetMapping("/students/{id}")
public Student getStudentById(@PathVariable Long id) {
    return studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
}
@GetMapping("/students")
public List<Student> getAllStudents() {
    return studentRepository.findAll();
}

@PutMapping("/students/{id}")
public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
    return studentRepository.findById(id)
            .map(student -> {
                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setEmail(updatedStudent.getEmail());
                student.setAge(updatedStudent.getAge());
                return studentRepository.save(student);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
}

@DeleteMapping("/students/{id}")
public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
    return studentRepository.findById(id)
            .map(student -> {
                studentRepository.delete(student);
                return ResponseEntity.ok().build();
            })
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
}
