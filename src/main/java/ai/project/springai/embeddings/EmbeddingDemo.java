package ai.project.springai.embeddings;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmbeddingDemo {

    private final EmbeddingModel embeddingModel;

    public EmbeddingDemo(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    @GetMapping("/showEmbedding")
    public String showEmbedDemo() {
        return "embedDemo";
    }

    @PostMapping("/embedding")
    public String embed(@RequestParam String text, Model model) {

        float[] embedding = embeddingModel.embed(text);

        model.addAttribute("embedding", embedding);
        model.addAttribute("text", text);

        return "embedDemo";
    }
}