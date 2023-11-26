package not.beat.cat.backend.repository.impl;

import not.beat.cat.backend.model.Document;
import not.beat.cat.backend.repository.FileRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Repository
public class FileDiskRepository implements FileRepository {
    private static final Path DOCUMENTS_PATH = Path.of("./documents/");

    static {
        try {
            Files.createDirectories(DOCUMENTS_PATH);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public byte[] load(Document document) {
        try {
            return Files.readAllBytes(DOCUMENTS_PATH.resolve(Path.of(document.getLocation())));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void upload(Path path, byte[] data) {
        try {
            Files.write(path, data, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
