package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.Document;

import java.nio.file.Path;

public interface FileRepository {

    byte[] load(Document document);

    void upload(Path path, byte[] data);
}
