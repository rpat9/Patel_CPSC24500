package ExerciseTracker;

import java.util.Comparator;

public class CompareExercisesByCalories implements Comparator<Exercise> {

  /**
   * This method compares exercise by their calories, given any two exercises.
   * @param one The first exercise
   * @param two The second exercise
   */
  @Override
  public int compare(Exercise one, Exercise two) {
    double cal1 = one.calculateCalories();
    double cal2 = two.calculateCalories();

    if (cal1 < cal2) {
      return -1;
    } else if (cal1 == cal2) {
      return 0;
    } else {
      return 1;
    }
  }
}
