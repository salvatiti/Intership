namespace GradeBook
{
    public class Book
    {

        List<double> grades = new List<double>();

        public Book()
        {

        }

        public void AddGrade(double grade)
        {
            grades.Add(grade);
        }

        public Statistics getStatistics()
        {
            var result = new Statistics();
            result.Average = 0.0;
            result.High = double.MinValue;
            result.Low = double.MaxValue;

            foreach (double grade in grades)
            {
                result.High = Math.Max(grade, result.High);
                result.Low = Math.Min(grade, result.Low);
                result.Average += grade;
            }
            result.Average /= grades.Count;
            return result;
        }

    }

}