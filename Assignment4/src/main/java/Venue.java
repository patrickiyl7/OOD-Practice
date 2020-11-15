public class Venue {
  private Integer numSectionRow;
  private Integer numSectionCol;
  private Integer secRowCapacity;
  private Integer secColCapacity;
  private Section[][] sections;

  public Venue(Integer numSectionRow, Integer numSectionCol, Integer secRowCapacity, Integer secColCapacity) {
    this.numSectionRow = numSectionRow;
    this.numSectionCol = numSectionCol;
    this.sections = new Section[numSectionRow][numSectionRow];
    for(int i = 0; i < numSectionRow; i++)
    {
      for(int j = 0; j < numSectionCol; j++)
      {
        sections[i][j] = new Section(i, j, secRowCapacity, secColCapacity);
      }
    }
  }


  public Section[][] getSections() {
    return sections;
  }

  public Integer getNumSectionRow() {
    return numSectionRow;
  }

  public Integer getNumSectionCol() {
    return numSectionCol;
  }

  public int remainSeatOverAll()
  {
    int res = 0;
    for(int i = 0; i < sections.length; i++)
    {
      for(int j = 0; j < sections[0].length; j++)
      {
        res += sections[i][j].remainRegularSeatCount();
        res += sections[i][j].remainWheelAccessibilitySeatCount();
      }
    }
    return res;
  }

  public int compromisedSeatArrangement()
  {
    int res = 0;
    for(int i = 0; i < sections.length; i++)
    {
      for(int j = 0; j < sections[0].length; j++)
      {
        res += sections[i][j].wheelChairSeatAssignedToNonWheelChairReqPerson();
      }
    }
    return res;
  }
}
