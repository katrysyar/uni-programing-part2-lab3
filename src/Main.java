public class Main {
    public static void main(String[] args) {
        String text = "Ознайомлення з рядками та використання основних методів їх обробки в мові програмування Java." +
                "Здобуття навичок у використанні рядків в мові програмування Java.";

        try {
            if (text == null || text.trim().isEmpty()) {
                System.out.println("Текст не заданий.");
                return;
            }

            String[] sentences = text.split("[.!?]+");

            String cleanText = text.toLowerCase().replaceAll("[^a-zа-яієїґ0-9\\s]", " ");
            String[] allWords = cleanText.trim().split("\\s+");

            int maxSentencesCount = 0;
            String topWord = "";

            for (int i = 0; i < allWords.length; i++) {
                String currentWord = allWords[i];
                if (currentWord.isEmpty()) continue;

                boolean alreadyProcessed = false;
                for (int k = 0; k < i; k++) {
                    if (allWords[k].equals(currentWord)) {
                        alreadyProcessed = true;
                        break;
                    }
                }
                if (alreadyProcessed) continue;

                int sentenceCount = 0;

                for (String sentence : sentences) {
                    String cleanSentence = sentence.toLowerCase().replaceAll("[^a-zа-яієїґ0-9\\s]", " ");
                    String[] wordsInSentence = cleanSentence.trim().split("\\s+");

                    for (String wordInSent : wordsInSentence) {
                        if (wordInSent.equals(currentWord)) {
                            sentenceCount++;
                            break;
                        }
                    }
                }

                if (sentenceCount > maxSentencesCount) {
                    maxSentencesCount = sentenceCount;
                    topWord = currentWord;
                }
            }

            System.out.println("Оригінальний текст:\n" + text + "\n");
            System.out.println("Найбільша кількість речень, в яких є однакове слово: " + maxSentencesCount);

        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
