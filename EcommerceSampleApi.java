@PostMapping("/products")
public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
}
@GetMapping("/products/{id}")
public Product getProductById(@PathVariable Long id) {
    return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
}
@GetMapping("/products")
public List<Product> getAllProducts() {
    return productRepository.findAll();
}
@PutMapping("/products/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    return productRepository.findById(id)
            .map(product -> {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                product.setQuantity(updatedProduct.getQuantity());
                return productRepository.save(product);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
}
@DeleteMapping("/products/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    return productRepository.findById(id)
            .map(product -> {
                productRepository.delete(product);
                return ResponseEntity.ok().build();
            })
            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
}
@GetMapping("/products/search")
public List<Product> searchProductsByName(@RequestParam String name) {
    return productRepository.findByNameContainingIgnoreCase(name);
}
