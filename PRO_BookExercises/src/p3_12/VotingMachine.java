package p3_12;

public class VotingMachine {
    private int democratVotes;
    private int republicanVotes;

    public VotingMachine() {
        this.democratVotes = 0;
        this.republicanVotes = 0;
    }

    public void voteDemocrat() { this.democratVotes++; }
    public void voteRepublican() { this.republicanVotes++; }
    public int getDemocratVotes() { return this.democratVotes; }
    public int getRepublicanVotes() { return this.republicanVotes; }
    public void reset() {
        this.democratVotes = 0;
        this.republicanVotes = 0;
    }
}
