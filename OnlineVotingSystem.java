import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {
    private Map<String, Integer> candidates = new HashMap<>();
    private int totalVotes = 0;

    public OnlineVotingSystem() {
        candidates.put("Alice", 0);
        candidates.put("Bob", 0);
        candidates.put("Charlie", 0);
    }

    public void castVote(String candidate) {
        if (candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1);
            totalVotes++;
            System.out.println("Vote casted for " + candidate);
        } else {
            System.out.println("Invalid candidate.");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();
            double percentage = (totalVotes == 0) ? 0 : (votes * 100.0 / totalVotes);
            System.out.printf("%s: %d votes (%.2f%%)\n", candidate, votes, percentage);
        }
    }

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Online Voting System!");
        System.out.println("Candidates: Alice, Bob, Charlie");
        System.out.println("Type 'exit' to finish voting.");

        while (true) {
            System.out.print("Enter your vote: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            votingSystem.castVote(input);
        }

        votingSystem.displayResults();
        scanner.close();
    }
}

